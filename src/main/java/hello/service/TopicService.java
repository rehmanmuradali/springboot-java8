package hello.service;

import hello.declaration.CustomPredicate;
import hello.model.Topic;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class TopicService {


    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Java Description"),
            new Topic("javascript", "javascript Framework", "javascript Framework Description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    /**
     * Strean Example
     *
     * @param id
     * @return
     */
    public Topic getTopicWithId(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    /**
     * IntStream examples
     *
     * @param id
     * @param topic
     */
    public void updateTopic(String id, Topic topic) {
        OptionalInt indexOfElement = IntStream.range(0, topics.size()).filter(index -> id.equals(topics.get(index).getId())).findFirst();
        if (indexOfElement.isPresent()) topics.set(indexOfElement.getAsInt(), topic);
    }

    /**
     * Lamda Expressions
     *
     * @param id
     */
    public void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }

    /**
     * Calling fucntional Interface
     *
     * @param minLength
     * @return
     */
    public List<Topic> filterMinimumLengthForId(Integer minLength) {
        return printTopicsWithPredicate(topics, topic -> topic.getId().length() > minLength);
    }


    /**
     * Functional Interface example With ForEach
     *
     * @param topicList
     * @param tester
     * @return
     */
    private static List<Topic> printTopicsWithPredicate(List<Topic> topicList, CustomPredicate<Topic> tester) {
        List<Topic> resultTopic = new ArrayList<>();
        topicList.forEach(topic -> {
            if (tester.test(topic)) resultTopic.add(topic);
        });
        return resultTopic;
    }


    /**
     * Using Comparator to sort
     *
     * @return
     */
    public List<Topic> sortTopicsWithID() {
        topics.sort(Comparator.comparing(Topic::getId));
        return topics;
    }


    /**
     * Join List of Strings
     *
     * @return
     */
    public String returnAllTopicIDWithStringSlicing() {
        List<String> topicIds = topics.stream().map(topic -> topic.getId()).collect(Collectors.toList());
        return String.join(":", topicIds);
    }


    /**
     * Use of MapToObject and distinct
     *
     * @param join
     * @return
     */
    public String makeDistinctAndSortCharacters(String join) {
        return join.chars().distinct()
                .mapToObj(id -> String.valueOf((char) id))
                .sorted()
                .collect(Collectors.joining());
    }


    /**
     * Use of Pattern Class with stream
     *
     * @param join
     * @return
     */
    public String splitAllIdWithColonSelectIDWithJavaKeywordThenSortThenJoin(String join) {
        return Pattern.compile(":")
                .splitAsStream(join)
                .filter(s -> s.contains("java"))
                .sorted()
                .collect(Collectors.joining(":"));
    }


    /**
     * Apply Regex as Predicate with Stream
     * @return
     */
    public String findIdHavingCharacter() {
        Pattern pattern = Pattern.compile(".*g.*");
        Object[] topicIdObjectList = topics.stream().map(topic -> topic.getId()).collect(Collectors.toList()).toArray();

        String[] topicIdList = Arrays.stream(topicIdObjectList).toArray(String[]::new);

        return Stream.of(topicIdList)
                .filter(pattern.asPredicate())
                .collect(Collectors.toList())
                .toString();
    }


    /**
     * NIO Java API
     * Use Streams with files
     * Try with resource, "Autoclose"
     *
     * @return
     */
    public String findAllFilesInPathAndSort() {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            return joined;
        } catch (IOException e) {
            return " Error in IO";
        }
    }

    /**
     * Using File.find function to find file
     * @return
     */
    public String findParticularFileInPathAndSort() {
        Path start = Paths.get("");
        int maxDepth = 25;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).startsWith("grad"))) {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; "));
            return joined;
        } catch (IOException e) {
            return " IO exception ";
        }
    }


    /**
     * Using Files.Walk Function to find File
     * @return
     */
    public String findParticularFileInPathAndSortWithWalkFunction() {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> path.startsWith("grad"))
                    .sorted()
                    .collect(Collectors.joining("; "));
            return joined;
        } catch (IOException e) {
            return " IO exception ";
        }
    }


    /**
     * Use BufferedReader with Stream functions
     * @return
     */
    public String readFileWithStreamFunction() {
        Path path = Paths.get("temp.txt");
        System.out.println();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String lines = reader
                    .lines()
                    .filter(line->line.contains("print"))
                    .map(line->line.substring("print".length()))
                    .collect(Collectors.joining(","));
            return  lines;
        } catch (IOException e) {
            return " IO exception ";
        }
    }

}
