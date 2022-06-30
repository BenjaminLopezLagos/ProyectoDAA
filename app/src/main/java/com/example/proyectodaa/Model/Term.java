package com.example.proyectodaa.Model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Term {
    private String concept;
    private String definition;
    private String reference;

    public Term(String concept, String definition, String reference) {
        this.concept = concept;
        this.definition = definition;
        this.reference = reference;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @NonNull
    @Override
    public String toString() {
        return
                definition +
                        "\n\n" + reference;
    }
}
