package outsidepackagescan;

import org.springframework.stereotype.Component;

@Component
public class OutsideClassRead {
    public String fromotherclass ;

    public OutsideClassRead(){
        fromotherclass = "outside class";
    }
}
