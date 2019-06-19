package xyz.stxkfzx.manager.face.ai.pojo;

public class AiAddFaceBase extends AiBase{
    private AiAddFaceResult result;

    @Override
    public String toString() {
        return "AiAddFaceBase{" +
                "result=" + result +
                '}';
    }

    public AiAddFaceResult getResult() {
        return result;
    }

    public void setResult(AiAddFaceResult result) {
        this.result = result;
    }
}
