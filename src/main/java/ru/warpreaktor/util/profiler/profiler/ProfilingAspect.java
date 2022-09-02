package ru.warpreaktor.util.profiler.profiler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ru.warpreaktor.util.profiler.Slog;

/**
 * ProfilingAspect - это класс который способен перехватывать генерируемые бины в фазе пост процессинга и инжектить в
 * них дополнительную логику. Проще говоря, по вашему желанию в ваши методы и классы будет добавлен замер
 * времени его работы без изменения его кодовой базы.
 *
 * <p>Для начала работы с профилированием необходимо:
 * <p> 1. Добавить зависимость в pom файл:
 *
 * <p>&lt;dependency&gt;
 * <p>&lt;groupId&gt;ru.softlab.efr.services&lt;/groupId&gt;
 * <p>&lt;artifactId&gt;common-components-service-utils&lt;/artifactId&gt;
 * <p>&lt;version&gt;1.0.0&lt;/version&gt;
 * <p>&lt;/dependency&gt;
 *
 * <p>2. Скопировать конфигурационный класс ProfilingConfiguration из папки ru.softlab.efr.utils.common.config в
 * директорию вашего проекта. При необходимости внести изменения в конфигурацию.
 * По умолчанию профилировщик создаст файл profiling.txt в докер-контейнере по пути /tmp/share/
 * однако вы можете самостоятельно сконфигурировать бин slog воспользовавшись конструктором в который можно передать
 * путь к директории куда следует логгировать.
 *
 * <p>3.Добавить аннотацию @Profiling над методом который необходимо профилировать, скомпилировать проект и изучать замеры.
 *
 * <p>Внимание!
 * <p>Этот профилировщик НЕ следует применять в классах которые имеют аннотации контроллера типа {@code @Controller,
 * @RequestMapping etc} так как он попросту удалит все эти аннотации в момент проксирования вашего класса, т.е.
 * проще говоря контроллер перестанет работать.
 * <p> Так же учтите, что при проксировании ваших классов помеченных как @Profiling все методы помеченные @Transactional
 * так же перестанут быть транзакицонными. Т.е. не следует применять данный профилировщик в продакшен коде =)
 *
 */
@Aspect
public class ProfilingAspect {

    private final Slog slog;

    public ProfilingAspect() {
        this.slog = new Slog();
    }

    public ProfilingAspect(Slog slog) {
        this.slog = slog;
    }

    @Pointcut("@annotation(ru.softlab.efr.utils.common.profiler.Profiling)")
    public void profilingMethods(){}

    @Around("profilingMethods()")
    public Object  aroundProfilingMethods(ProceedingJoinPoint joinPoint) throws Throwable{
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        slog.logT(String.format("{ ### START PROFILING class: %s ;\n method: %s \n",
                className, methodName));
        long start = System.currentTimeMillis();
        Object retVal = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long timeSpent = end - start;
        slog.logT(String.format(" class: %s ;\n method: %s ; Time spent = %s ms END PROFILING ### }\n",
                className, methodName, timeSpent));
        return retVal;
    }

}
