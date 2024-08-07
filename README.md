# API Project Ideas Generator

## Overview

This project includes a Java application that generates fun project ideas by combining APIs from a provided list. The application uses the `langchain4j` library to interface with the Ollama language model and generate ideas based on a given prompt.

## Components

1. **`Main` Class**: The entry point of the application that initializes the `IdeasGenerator`, reads API data from a file, and sends a prompt to the language model to generate project ideas.
2. **`IdeasGenerator` Class**: Handles reading API data from a file, storing it, and picking random APIs from the list.
3. **`ApiData` Class**: Represents the API data with a name, URL, and description.

## Dependencies

- `dev.langchain4j.model.chat.ChatLanguageModel`
- `dev.langchain4j.model.ollama.OllamaChatModel`

## Setup