$('#search-keywords').on('click', event => {
    event.currentTarget.classList.add('is-loading')
    searchEvents().then(events => {

    })
});

function searchEvents() {
    return fetch('/events/search', {
        credentials: "same-origin"
    }).then(result => {
        return result.json()
    })
}