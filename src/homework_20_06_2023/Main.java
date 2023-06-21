package homework_20_06_2023;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/homework_20_06_2023/data/InfoUsers.json");
             FileWriter writer = new FileWriter("src/homework_20_06_2023/data/InfoUsers.txt");
             FileWriter writerJson = new FileWriter("src/homework_20_06_2023/data/TestInfoUsers.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObj = (JSONObject) obj;
            JSONObject result = new JSONObject();

            String name = (String) jsonObj.get("name");
            writer.write("Name: " + name);
            result.put("name", "Reece James");
            Long age = (Long) jsonObj.get("age");
            writer.write("\nAge: " + age);
            result.put("age", 21);
            String email = (String) jsonObj.get("email");
            writer.write("\nEmail: " + email);
            result.put("email", email);

            JSONObject address = (JSONObject) jsonObj.get("address");
            List<String> addressInfo = new ArrayList<>();
            addressInfo.add("\nStreet: " + address.get("street"));
            addressInfo.add("\nCity: " + address.get("city"));
            addressInfo.add("\nState: " + address.get("state"));
            addressInfo.add("\nZipcode: " + address.get("zipcode"));
            writer.write("\nAddress: " + addressInfo);

            JSONObject addressJson = new JSONObject();
            addressJson.put("street", "17 Brooklyn St");
            addressJson.put("city", address.get("city"));
            addressJson.put("state", address.get("state"));
            addressJson.put("zipcode", "10101011010");
            result.put("address", addressJson);

            JSONArray phones = (JSONArray) jsonObj.get("phoneNumbers");
            List<JSONObject> phonesObj = new ArrayList<>();
            for (Object phone : phones) {
                phonesObj.add((JSONObject) phone);
            }
            List<String> phoneNumbers = new ArrayList<>();
            for (JSONObject jsonObject : phonesObj) {
                phoneNumbers.add("\n{type: " + jsonObject.get("type") + "\nnumber: " + jsonObject.get("number") + "}");
                if (jsonObject.get("type").equals("home")) {
                    jsonObject.put("number", "777-5678");
                }
            }
            writer.write("\nPhone Numbers: " + phoneNumbers);
            result.put("phoneNumbers", phonesObj);

            Boolean isPremium = (Boolean) jsonObj.get("isPremium");
            writer.write("\nisPremium: " + isPremium);
            result.put("isPremium", false);
            JSONArray jsonTags = (JSONArray) jsonObj.get("tags");
            List<String> tags = new ArrayList<>();
            for (Object tag : jsonTags) {
                tags.add((String) tag);
            }
            for (String tag : tags) {
                if (tag.equals("example")) {
                    tags.set(tags.indexOf("example"), "task");
                }
            }
            writer.write("\nTags: " + tags);
            result.put("tags", tags);

            JSONArray jsonFriends = (JSONArray) jsonObj.get("friends");
            List<JSONObject> friendsObj = new ArrayList<>();
            for (Object friend : jsonFriends) {
                friendsObj.add((JSONObject) friend);
            }
            List<Object> friends = new ArrayList<>();
            for (JSONObject friend : friendsObj) {
                friends.add("\n{Name: " + friend.get("name") + "\nAge: " + friend.get("age") + "\nEmail: " + friend.get("email") + "}");
                if (friend.get("name").equals("Bob")) {
                    friend.put("name", "Mason");
                    friend.put("age", 23);
                    friend.put("email", "mason@example.com");
                }
            }
            writer.write("\nFriends: " + friends);
            result.put("friends", friendsObj);
            writerJson.write(result.toJSONString());
            System.out.println("Writing is complete!");
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
