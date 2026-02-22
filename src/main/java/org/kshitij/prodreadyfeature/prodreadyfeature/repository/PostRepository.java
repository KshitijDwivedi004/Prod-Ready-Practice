package org.kshitij.prodreadyfeature.prodreadyfeature.repository;

import org.kshitij.prodreadyfeature.prodreadyfeature.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
