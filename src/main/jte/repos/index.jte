@import java.util.List
@import com.pedroreis.dev.model.Repo

@param List<Repo> repos

@template.layout(
title = "Projects",
content = @`
    <h1>Projects (${repos.size()})</h1>

    <a href="/" title="Go back">Go back</a>

    @for (var repo: repos)
        <section class='repo'>
            @template.repos._repo(repo=repo)
        </section>
    @else
        <p>Projects are under maintenance</p>
    @endfor
`)
