package xyz.stxkfzx.manager.user.pojo;

import java.sql.*;

public class TSignItem {
    private int id;
    private int uid;
    private Timestamp signin;
    private Timestamp signout;
    private String signin_img;
    private String signout_img;

    public TSignItem() {
    }

    public TSignItem(final int id, final int uid, final Timestamp signin, final Timestamp signout, final String signin_img, final String signout_img) {
        this.id = id;
        this.uid = uid;
        this.signin = signin;
        this.signout = signout;
        this.signin_img = signin_img;
        this.signout_img = signout_img;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(final int uid) {
        this.uid = uid;
    }

    public Timestamp getSignin() {
        return this.signin;
    }

    public void setSignin(final Timestamp signin) {
        this.signin = signin;
    }

    public Timestamp getSignout() {
        return this.signout;
    }

    public void setSignout(final Timestamp signout) {
        this.signout = signout;
    }

    public String getSignin_img() {
        return this.signin_img;
    }

    public void setSignin_img(final String signin_img) {
        this.signin_img = signin_img;
    }

    public String getSignout_img() {
        return this.signout_img;
    }

    public void setSignout_img(final String signout_img) {
        this.signout_img = signout_img;
    }

    @Override
    public String toString() {
        return "TSignItem{" +
                "id=" + id +
                ", uid=" + uid +
                ", signin=" + signin +
                ", signout=" + signout +
                ", signin_img='" + signin_img + '\'' +
                ", signout_img='" + signout_img + '\'' +
                '}';
    }
}
