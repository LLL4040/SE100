var func = require('./apps.js');
var expect = require('chai').expect;

var books = [{
                id: 1,
                author: '曹雪芹',
                name: '红楼梦',
                price: 32.0
            }, {
                id: 2,
                author: '施耐庵',
                name: '水浒传',
                price: 30.0
            }, {
                id: 3,
                author: '罗贯中',
                name: '三国演义',
                price: 24.0
            }, {
                id: 4,
                author: '吴承恩',
                name: '西游记',
                price: 20.0
            }];
describe('求和函数的测试', function() {
  it('初始化状态下应该等于106', function() {
    expect(func.sum(books)).to.be.equal(106);
  });
});

describe('求和函数的测试', function() {
  it('没有书时应该等于0', function() {
    expect(func.sum([])).to.be.equal(0);
  });
});
