package hello.controller;

import hello.model.Topic;
import hello.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;


    /**
     * Get all Topic
     * @return
     */
    @RequestMapping("/topic")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    /**
     * get Topic with ID
     * @param id
     * @return
     */
    @RequestMapping("/topic/{id}")
    public Topic getTopicWithID(@PathVariable String id) {
        return topicService.getTopicWithId(id);
    }

    /**
     * Add a new topic in list
     * @param topic
     */
    @RequestMapping(method = RequestMethod.POST, value = "/topic")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    /**
     * Update Topic in List with id
     * @param id
     * @param topic
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }


    /**
     * Delete a topic with ID
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

    /**
     * Get all topics with Id length greater then minimum length
     * @param minLength
     * @return
     */
    @RequestMapping(value = "/topic/minimum/length/{minLength}")
    public List<Topic> filterMinimumLengthForId(@PathVariable Integer minLength) {
        return topicService.filterMinimumLengthForId(minLength);
    }


    /**
     * Sort with Id
     * @return
     */
    @RequestMapping("/topic/sort")
    public List<Topic> sortTopicsWithID() {
        return topicService.sortTopicsWithID();
    }






}
