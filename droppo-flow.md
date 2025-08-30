# Droppo Flowchart

How to read it:

- Diamond shapes → conditional checks (if)
- Rectangles → actions/commands (Maven build, scp, ssh)
- Exits → if check_success fails, the script stops immediately

<pre>
    Start
    |
    v
    Check arguments ($1 and $2)
    |
    |-- if either is empty --> Print usage & Exit
    |
    v
    Package project with Maven
    |
    v
    Check exit code with check_success
    |
    |-- if exit code != 0 --> Print "Maven build failed" & Exit
    |
    v
    Create remote directories
    |
    v
    Check exit code with check_success
    |
    |-- if exit code != 0 --> Print "Failed to create directories" & Exit
    |
    v
    Upload JAR via scp
    |
    v
    Check exit code with check_success
    |
    |-- if exit code != 0 --> Print "Failed to upload JAR" & Exit
    |
    v
    Upload SQLite database via scp
    |
    v
    Check exit code with check_success
    |
    |-- if exit code != 0 --> Print "Failed to upload database" & Exit
    |
    v
    Start app on remote server via ssh & nohup
    |
    v
    Check exit code with check_success
    |
    |-- if exit code != 0 --> Print "Failed to start app" & Exit
    |
    v
    Print "Deployment completed successfully!"
    |
    v
    End
</pre>
