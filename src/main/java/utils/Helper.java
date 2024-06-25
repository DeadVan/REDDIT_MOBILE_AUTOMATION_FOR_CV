package utils;

import java.util.Set;

public class Helper {

    public static String findTagWithMostUpVotes(Set<String> uniqueTags) {
        int maxUpvotes = Integer.MIN_VALUE;
        String fullTextOfTag = null;

        for (String text : uniqueTags) {
            String[] parts = text.split(", |\\. ");

            for (String part : parts) {
                if (part.matches("\\d+(\\.\\d+)?\\s*(thousand|million)?\\s*upvotes.*")) {
                    String[] upvotesPart = part.split(" ");
                    if (upvotesPart.length > 1) {
                        try {
                            double parsedDouble = Double.parseDouble(upvotesPart[0]);
                            int upvotes;
                            if (upvotesPart[0].contains(".")) {
                                upvotes = (int) (parsedDouble * 1000);
                            } else {
                                upvotes = (int) parsedDouble;
                            }
                            if (upvotes > maxUpvotes) {
                                maxUpvotes = upvotes;
                                fullTextOfTag = text;
                            }
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }

        return fullTextOfTag;
    }


}
