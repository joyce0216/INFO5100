package info5100;

public class Professor {
    private String firstName;
    private String lastName;
    private String id;

    private Professor(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String id;

        public Builder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setId(String id){
            this.id = id;
            return this;
        }

        public Professor build(){
            return new Professor(firstName, lastName, id);
        }
    }
}
