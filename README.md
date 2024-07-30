### Có thể move/dời class chứa hàm main sang nơi khác không? Vì sao?

- Có thể dời nhưng phải thêm name package gốc vào cho property basePackages của @ComponentScan
- Nếu không thêm thì khi chuyển class chứa main sang 1 package khác thì app sẽ bị error do:
    + @ComponentScan trong @SpringBootApplication nó nhận giá trị là name package chứa nó và nó chỉ scan được các component
      trong package đó