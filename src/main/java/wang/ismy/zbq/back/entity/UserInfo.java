package wang.ismy.zbq.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userInfoId;

    private String nickName;

    private String profile;

    private LocalDate birthday;

    private Integer penYear;

    private String region;

    private Integer gender;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
