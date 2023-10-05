package com.example.notes.controllers;

import com.example.notes.model.Notes;
import com.example.notes.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    private final NotesService notesService;

    public NoteController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping
    public ResponseEntity<Notes> createNote(@RequestBody Notes note){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(notesService.save(note));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable long id) {
        return ResponseEntity.ok(notesService.getNoteById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Notes> getNoteByTitle(@PathVariable String title){
        return ResponseEntity.ok(notesService.getNoteByTitle(title));
    }

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes(){
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notes> refactoringNotes(@PathVariable long id, @RequestBody Notes note){
        return ResponseEntity.ok(notesService.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable long id){
        notesService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
