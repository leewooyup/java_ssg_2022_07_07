package com.wy.ssg_prac;

public class WiseSaying {
    int id;
    String contents;
    String author;

    public WiseSaying(int id, String contents, String author) {
        this.id = id;
        this.contents = contents;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
