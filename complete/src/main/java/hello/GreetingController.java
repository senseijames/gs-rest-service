package hello;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
/*
@RestController annotation, which marks the class as a controller where every method 
returns a domain object instead of a view. It’s shorthand for @Controller and 
@ResponseBody rolled together.
 */
    // http://localhost:8080/greeting?name=blah, http://localhost:8080/greeting///?name=blah
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/quote")   
    public Greeting greetingPOST(@RequestParam(value="name", defaultValue="World") String name) {
        String randomQuote = QUOTES.get((int)Math.floor(QUOTES.size() * Math.random()));
    	return new Greeting(counter.incrementAndGet(),
    			 			randomQuote);
    }

    
    private static final List<String> QUOTES = Arrays.asList("With great power comes great responsibility.",
    		"It's not who I am underneath, but what I do, that defines me.",
    		"You have failed this city!",
    		"Look! Up in the Sky! It's a bird! It's a plane! It's... Superman!!",
    		"I'm whatever Gotham needs me to be.",
    		"True happiness is found along a middle road. There lies the balance and the harmony-- with reason and emotion, not at war but hand in hand",
    		"The greatest power on Earth is the magnificent power we - all of us - possess... the power of the human brain!",
    		"If there is nothing but what we make in this world, brothers... let us make good.",
    		"We choose what holds us back and what moves us forward.",
    		"It's clobberin' time!",
    		"Paradise unearned is but a land of shadows!",
    		"You're going to make a difference. A lot of times it won't be huge, it won't be visible even. But it will matter just the same.",
    		"In brightest day, in blackest night, no evil shall escape my sight. Let those who worship evil’s might, beware my power — Green Lantern’s light!",
    		"Excelsior!");
    
}
