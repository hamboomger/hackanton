('#search-keywords').on('click', event => {
    event.currentTarget.classList.add('is-loading')
    fetch('/events/search', {
        credentials: "same-origin"
    }).then(result => {
        result.json()
    })
});