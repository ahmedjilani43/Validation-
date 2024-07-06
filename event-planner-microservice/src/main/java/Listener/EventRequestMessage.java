package Listener;


import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventRequestMessage implements Serializable {
    private static final long serialVersionUID = 2322432303657657201L;
    private  Long eventId;
    private  Integer guestNumbers;
}

