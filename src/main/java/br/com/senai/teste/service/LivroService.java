package br.com.senai.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senai.teste.model.Livro;
import br.com.senai.teste.repository.LivroRepository;

@Service 
public class LivroService {
    
    @Autowired 
    private LivroRepository livroRepository;

    public Livro cadastrar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listar() {
        return  livroRepository.findAll();
    }

    public Livro buscarPorId(Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livroExistente = buscarPorId(id);
        if ((livroExistente != null)) {
            livroExistente.setTitulo(livroAtualizado.getTitulo());
            livroExistente.setAutor(livroAtualizado.getAutor());
            livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            return livroRepository.save(livroExistente);
        }
        return null;
    }

    public  void excluir(Long id) {
        livroRepository.deleteById(id);
    }
}
