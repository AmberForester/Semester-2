package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.util.Calendar;


public class JavaDate {
    public static void main(String[] args) {

        Calendar waktu1 = Calendar.getInstance();
        waktu1.set(Calendar.YEAR, 2023);
        waktu1.set(Calendar.MONTH, Calendar.MAY);
        waktu1.set(Calendar.DAY_OF_MONTH, 23);
        waktu1.set(Calendar.HOUR_OF_DAY, 10);
        waktu1.set(Calendar.MINUTE, 0);

        Calendar waktu2 = Calendar.getInstance();
        waktu2.set(Calendar.YEAR, 2023);
        waktu2.set(Calendar.MONTH, Calendar.JUNE);
        waktu2.set(Calendar.DAY_OF_MONTH, 1);
        waktu2.set(Calendar.HOUR_OF_DAY, 12);
        waktu2.set(Calendar.MINUTE, 0);

        long selisihMiliDetik = waktu2.getTimeInMillis() - waktu1.getTimeInMillis();
        long selisihDetik = selisihMiliDetik / 1000;
        long selisihMenit = selisihMiliDetik / (60 * 1000);
        long selisihJam = selisihMiliDetik / (60 * 60 * 1000);
        long selisihHari = selisihMiliDetik / (24 * 60 * 60 * 1000);

        long sisaJam = selisihJam - (selisihHari*24);
        long sisaMenit = selisihMenit - (selisihJam*60);

        System.out.print("Sisa waktu sebelum hari H : ");
        System.out.print(selisihHari+ " hari ");
        System.out.print(sisaJam + " jam ");
        System.out.println(sisaMenit + " menit ");

        System.out.printf("%-26s: %d\n", "Selisih dalam hari ", selisihHari);
        System.out.printf("%-26s: %d\n", "Selisih dalam jam ", selisihJam);
        System.out.printf("%-26s: %d\n", "Selisih dalam menit ", selisihMenit);
        System.out.printf("%-26s: %d\n", "Selisih dalam detik ", selisihDetik);
    }
}
