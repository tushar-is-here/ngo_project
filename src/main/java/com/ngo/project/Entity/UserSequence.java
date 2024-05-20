package com.ngo.project.Entity;

import com.ngo.project.Utils.UserSequenceId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSequence {
    @EmbeddedId
    private UserSequenceId id;
    private int sequence;
}
