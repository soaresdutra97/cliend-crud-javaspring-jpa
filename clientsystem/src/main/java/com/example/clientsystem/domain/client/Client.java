package com.example.clientsystem.domain.client;
import lombok.*;
import jakarta.persistence.*;


@Table(name="client")
@Entity(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    private Boolean active;

    //criar construtor adicional após criar a requestProduct que recebe via http. \/ \/ \/ \/

    public Client(RequestClient requestClient){
        this.name = requestClient.name();
        this.email = requestClient.email();
        this.active = true;
    }

}
