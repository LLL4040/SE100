var func = {
    sum:function(books){
            var result = 0;
            for (var i = 0; i < books.length; i++){
                result += Number(books[i].price);
            }
            return result;
        },
}

module.exports = func;