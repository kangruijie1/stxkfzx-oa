package xyz.stxkfzx.manager.face.pojo;

import java.sql.Timestamp;

public class TSignItemNew {
    private Integer signItemId;
    private Integer userId;
    private Timestamp signInTime;
    private Timestamp signOutTime;
    private Integer signInImgId;
    private Integer signOutImgId;

    public TSignItemNew() {
    }

    public Integer getSignItemId() {
        return signItemId;
    }

    public void setSignItemId(Integer signItemId) {
        this.signItemId = signItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Timestamp signInTime) {
        this.signInTime = signInTime;
    }

    public Timestamp getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Timestamp signOutTime) {
        this.signOutTime = signOutTime;
    }

    public Integer getSignInImgId() {
        return signInImgId;
    }

    public void setSignInImgId(Integer signInImgId) {
        this.signInImgId = signInImgId;
    }

    public Integer getSignOutImgId() {
        return signOutImgId;
    }

    public void setSignOutImgId(Integer signOutImgId) {
        this.signOutImgId = signOutImgId;
    }

    @Override
    public String toString() {
        return "TSignItemNew{" +
                "signItemId=" + signItemId +
                ", userId=" + userId +
                ", signInTime=" + signInTime +
                ", signOutTime=" + signOutTime +
                ", signInImgId=" + signInImgId +
                ", signOutImgId=" + signOutImgId +
                '}';
    }
}
