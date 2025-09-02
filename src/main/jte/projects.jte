@import java.util.List
@import com.pedroreis.dev.Repo
@import static com.pedroreis.dev.Templates.join
@import static com.pedroreis.dev.Templates.date

@param List<Repo> projects
@param int quantity

@template.layout(
title = "Projects",
content = @`
    <h1>Projects Overview (${quantity})</h1>

    @for (var repo: projects)
        <section id='${repo.id()}' class='repo'>
            @template.project(repo)
        </section>
    @else
        <p>Projects are under maintenance</p>
    @endfor
`)
