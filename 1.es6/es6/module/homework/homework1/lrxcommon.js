//创建导出
// export const cat = {
//     name:"lrx",
//     age:10,
//     cry() {
//         console.log("cat cry()")
//     }
// }
//
// const dog = {
//     name:"zzz",
//     age:8,
//     hi() {
//         console.log("dog hi()")
//     }
// }
//批量导出
// export {
//     cat,
//     dog
// }



export default {
    cat: {
        name:"lrx",
        age:10,
        cry() {
            console.log("cat cry()")
        }
    },

    dog : {
        name:"zzz",
        age:8,
        hi() {
            console.log("dog hi()")
        }
    }
}