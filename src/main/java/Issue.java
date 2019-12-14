import org.apache.commons.lang3.RandomStringUtils;

public class Issue {
    public String summary;
    public String description;
    public String id;

    public Issue(String summary, String description) {
        this.summary = summary;
        this.description = description;
    }

    public static Issue createValidOnelineIssue() {
        return new Issue("Division by zero", "Calculator failed with exception");
    }

    public static Issue createValidMultilineIssue() {
        return new Issue("Division by zero\n 5 / 0 = ???", "Calculator failed with exception\n Should not be zero");
    }

    public static Issue createEmpty() {
        return new Issue("", "");
    }

    public static Issue createWithEmptySummary() {
        return new Issue("", "Calculator failed with exception");
    }

    public static Issue createWithEmptyDescription() {
        return new Issue("Division by zero", "");
    }

    public static Issue createWithLongSummary() {
        String summary = getRandomString(1000);
        return new Issue(summary, "Calculator failed with exception");
    }

    public static Issue createWithLongDescription() {
        String description = getRandomString(1000);
        return new Issue("Division by zero", description);
    }

    public static Issue createWithSpecificSummarySymbols() {
        return new Issue("Деление на ноль!? 123421\uD83D\uDC7D", "Calculator failed with exception");
    }

    public static Issue createWithSpecificDescriptionSymbols() {
        return new Issue("Division by zero", "Ошибка калькулятора : 123432 \uD83D\uDE03");
    }

    private static String getRandomString(int n) {
        return RandomStringUtils.random(n, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ");
    }
}
