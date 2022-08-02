package com.company.lambda;

public class Task03 {

    //�������� � �������� ��������� ������-���������.
    //����������� ������������ �������:
    //�������� �� ���;
    //������� �� ���;

    public static void main(String[] args) {

        Max max = (f, s, t) -> {
            int result = 0;
            if (f > t) {
                if (f > s) {
                    result = f;
                }
            } else if (t > s) {
                result = t;
            } else {
                result = s;
            }
            return result;
        };
        System.out.println(max.max(123, 345, 213));

        Min min = (f, s, t) -> {
            int result = 0;
            if (f < t) {
                if (f < s) {
                    result = f;
                }
            } else if (t < s) {
                result = t;
            } else {
                result = s;
            }
            return result;
        };
        System.out.println(min.min(0, 1, 14));
    }

    @FunctionalInterface
    public interface Max {
        int max(int first, int second, int third);
    }

    @FunctionalInterface
    public interface Min {
        int min(int first, int second, int third);
    }
}
