package SESSION02_02;

public class Student {
    private String fullName;
    private int score;

    // Constructor như bạn yêu cầu
    public Student(String fullName, int score) {
        this.fullName = fullName;
        this.score = score;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public int getScore() {
        return score;
    }

    // Setters (nếu cần đổi điểm sau này)
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}