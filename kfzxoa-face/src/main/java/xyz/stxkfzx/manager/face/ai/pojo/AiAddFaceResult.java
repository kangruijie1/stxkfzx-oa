package xyz.stxkfzx.manager.face.ai.pojo;

public class AiAddFaceResult {
    private String face_token;
    private AiLocation location;

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public String getFace_token() {
        return face_token;
    }

    public void setLocation(AiLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AiAddFaceResult{" +
                "face_token='" + face_token + '\'' +
                ", location=" + location +
                '}';
    }

    public AiLocation getLocation() {
        return location;
    }
}
