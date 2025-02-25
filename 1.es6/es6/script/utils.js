function getAjax(url,data) {
    return new Promise((resolve, reject) => {
        $.ajax({
            url:url,
            data:data,
            success(resultData) {

                resolve(resultData);
            },
            error(err) {
                reject(err);
            }
        })
    })
}