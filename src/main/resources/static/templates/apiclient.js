apiclient = (function () {
    return {
        getCinemaByName: function (name, callback) {
            console.log(name);
            $.get("/cinemas/" + name, function (data) {
                callback(data);
            });
        },
        saveTickets: function (cine, movieName, row, col, date, callback) {
            $.post("/cinemas/" + cine + "/" + movieName + "/" + row + "/" + col + "/" + date, function (data) {
                callback(data);
            });
        }

    }

})();