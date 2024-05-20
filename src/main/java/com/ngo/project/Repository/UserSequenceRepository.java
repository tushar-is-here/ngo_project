package com.ngo.project.Repository;

import com.ngo.project.Entity.UserSequence;
import com.ngo.project.Utils.UserSequenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSequenceRepository extends JpaRepository<UserSequence, UserSequenceId> {
}
