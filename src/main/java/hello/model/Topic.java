package hello.model;


public class Topic {
    private String id;
    private String subjectName;
    private String subjectDescription;

    public Topic() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public Topic(String id, String subjectName, String subjectDescription) {
        super();
        this.id = id;
        this.subjectName = subjectName;
        this.subjectDescription = subjectDescription;
    }

}
