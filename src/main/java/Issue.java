import org.apache.commons.lang3.RandomStringUtils;

public class Issue {
    public String summary;
    public String description;
    public String id;

    public Issue(String summary, String description) {
        this.summary = summary;
        this.description = description;
    }

    public static Issue createValidIssue() {
        return new Issue("Division by zero", "Calculator failed with exception");
    }

    public static Issue createIssueWithoutSummary() {
        return new Issue("", "Calculator failed with exception");
    }

    public static Issue createIssueWithLongSummary() {
        String summary = getRandomString(1000);
        return new Issue(summary, "Calculator failed with exception");
    }

    public static Issue createIssueWithLongDescription() {
        String description = getRandomString(1000);
        return new Issue("Division by zero", description);
    }

    public static Issue createIssueWithSpecificSymbols() {
        return new Issue("Деление на ноль!? 123421\uD83D\uDC7D", "\uD83D\uDE03");
    }

    private static String getRandomString(int n) {
        return RandomStringUtils.random(n, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ");
    }
}
