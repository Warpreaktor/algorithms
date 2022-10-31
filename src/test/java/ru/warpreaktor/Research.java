package ru.warpreaktor;

class Research {

    public static void main(String[] args) {
        Integer a = Integer.valueOf(5);
//        System.out.println(a.getClass());
        try {
            a.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}