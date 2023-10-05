package com.example.notes.repositories;

import com.example.notes.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    Notes findByTitle(String title);

}
