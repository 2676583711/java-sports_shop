package cn.zhou.core.web;

public class a {
    private static a ourInstance = new a();

    public static a getInstance() {
        return ourInstance;
    }

    private a() {
    }
}
