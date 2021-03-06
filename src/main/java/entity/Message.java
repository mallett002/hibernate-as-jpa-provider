package entity;

import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEXT")
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
