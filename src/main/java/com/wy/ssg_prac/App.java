package com.wy.ssg_prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;
    public App() {
        sc = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }
    public void run() {
        System.out.println("== 명언 SSG ==");

        
        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);
            switch(rq.getPath()) {
                case "종료":
                    break outer;
                case "등록":
                    write(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "목록":
                    list(rq);
                    break;
            }
        }
        sc.close();
    }

    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for(int i = wiseSayings.size()-1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.contents, wiseSaying_.author);
        }
    }

    private void remove(Rq rq) {
        int paramId = rq.getIntParam("id",0);

        if(paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = null;

        for(WiseSaying wiseSaying___ : wiseSayings) {
            if(wiseSaying___.id == paramId) {
                foundWiseSaying = wiseSaying___;
            }
        }

        if(foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        wiseSayings.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    private void write(Rq rq) {
        int id = ++wiseSayingLastId;
        System.out.print("명언 : ");
        String contents = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, contents, author);
        wiseSayings.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }
}
