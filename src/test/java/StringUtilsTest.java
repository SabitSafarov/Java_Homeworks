import org.example.homework_28_06_2023.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        String expected = "olleh";
        Assert.assertEquals(expected, StringUtils.reverse("hello"));
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(StringUtils.isPalindrome("доход"));
    }

    @Test
    public void testCountOccurrences() {
        int expected = 3;
        Assert.assertEquals(expected, StringUtils.countOccurrences("Hello world", 'l'));
    }

    @Test
    public void testRemoveDuplicates() {
        String expected = "helo";
        Assert.assertEquals(expected, StringUtils.removeDuplicates("hello"));
    }

    @Test
    public void testSplitByDelimiter() {
        String input = "London is a capital of Great Britain";
        String[] expected = input.split(" ");
        Assert.assertEquals(expected, StringUtils.splitByDelimiter(input, " "));
    }

    @Test
    public void testIsAnagram() {
        Assert.assertFalse(StringUtils.isAnagram("Java", "Spring"));
    }
}
