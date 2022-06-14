package wang.ismy.zbq.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer userId;

    private String username;

    private String password;

    private Integer userInfo;

    private Integer permission;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime lastLogin;

    @Override
    public int hashCode(){
        return userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj instanceof User){
            var i = (User)obj;
            return i.getUserId().equals(userId);
        }else{
            return false;
        }
    }
}
