
const sum = function (a,b) {
    return parseInt(a) + parseInt(b);
}

const sub = function (a,b) {
    return parseInt(a) - parseInt(b);
}

let name = "lrx";

const monster = {
    name:"牛魔王",
    age:200
}

// export {
//     sum,
//     sub,
//     name
// }

module.exports = {
    name,
    monster
}