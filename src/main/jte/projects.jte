@import java.util.List
@import com.pedroreis.dev.Repo
@import static com.pedroreis.dev.Templates.join
@import static com.pedroreis.dev.Templates.date

@param List<Repo> repos

@template.layout(
title = "Projects",
content = @`
    <h1>Projects (${repos.size()})</h1>

    <a href="/" title="Go back">Go back</a>

    @for (var repo: repos)
        <section id='${repo.id()}' class='repo'>
            @template.project(repo)
        </section>
    @else
        <p>Projects are under maintenance</p>
    @endfor
`)
