package com.wy.ssg_prac;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        int wiseSayingLastId = 0;
        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd) {
                case "종료":
                    break outer;
                case "등록":
                    int id = ++wiseSayingLastId;
                    System.out.print("명언 : ");
                    String contents = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();

                    WiseSaying wiseSaying = new WiseSaying(id, contents, author);
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
            }
        }
        sc.close();
    }
}
