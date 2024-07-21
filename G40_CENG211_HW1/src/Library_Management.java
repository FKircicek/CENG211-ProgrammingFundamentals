public class Library_Management {
    private Issue[][] issues;

    public Library_Management(Issue[][] issues) {
        this.issues = issues;
    }

    public Issue[][] getIssues() {
        Issue[][] copyArray = new Issue[3][30];

        for(int j =0; j< 3; j++){
            for ( int i =0; i< 30; i++){
                if ( issues[j][i] != null) {
                    copyArray[j][i] = issues[j][i];
                }
            }
        }
        return copyArray;
    }

    public void setIssues(Issue[][] issues) {
        this.issues = issues;
    }
}
