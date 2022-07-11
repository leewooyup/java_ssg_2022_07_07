package com.wy.ssg_prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> wiseSayings = new ArrayList<>();
        int wiseSayingLastId = 0;
        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);
            switch(rq.getPath()) {
                case "종료":
                    break outer;
                case "등록":
                    int id = ++wiseSayingLastId;
                    System.out.print("명언 : ");
                    String contents = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();

                    WiseSaying wiseSaying = new WiseSaying(id, contents, author);
                    wiseSayings.add(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "삭제":
                    int paramId = rq.getIntParam("id",0);

                    if(paramId == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    WiseSaying wiseSaying__ = null;

                    for(WiseSaying wiseSaying___ : wiseSayings) {
                        if(wiseSaying___.id == paramId) {
                            wiseSaying__ = wiseSaying___;
                        }
                    }

                    if(wiseSaying__ == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
                        continue;
                    }

                    wiseSayings.remove(wiseSaying__);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("------------------");
                    for(int i = wiseSayings.size()-1; i >= 0; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.contents, wiseSaying_.author);
                    }
                    break;
            }
        }
        sc.close();
    }
}
