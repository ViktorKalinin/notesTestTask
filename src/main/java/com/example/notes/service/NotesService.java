package com.example.notes.service;

import com.example.notes.model.Notes;

import java.util.List;

public interface NotesService {

    Notes save(Notes note);

    Notes getNoteById(long id);

    Notes getNoteByTitle(String title);

    List<Notes> getAllNotes();

    Notes updateNote(long id, Notes note);

    void deleteNote(long id);

}
