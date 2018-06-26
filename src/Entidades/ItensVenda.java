/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author a1711997
 */
@Entity
@Table(name = "itens_venda")
@NamedQueries({
    @NamedQuery(name = "ItensVenda.findAll", query = "SELECT i FROM ItensVenda i")})
public class ItensVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItensVendaPK itensVendaPK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "id_venda", referencedColumnName = "id_venda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public ItensVenda() {
    }

    public ItensVenda(ItensVendaPK itensVendaPK) {
        this.itensVendaPK = itensVendaPK;
    }

    public ItensVenda(ItensVendaPK itensVendaPK, int quantidade, int valor) {
        this.itensVendaPK = itensVendaPK;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public ItensVenda(int idVenda, int idProduto) {
        this.itensVendaPK = new ItensVendaPK(idVenda, idProduto);
    }

    public ItensVendaPK getItensVendaPK() {
        return itensVendaPK;
    }

    public void setItensVendaPK(ItensVendaPK itensVendaPK) {
        this.itensVendaPK = itensVendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensVendaPK != null ? itensVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensVenda)) {
            return false;
        }
        ItensVenda other = (ItensVenda) object;
        if ((this.itensVendaPK == null && other.itensVendaPK != null) || (this.itensVendaPK != null && !this.itensVendaPK.equals(other.itensVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ItensVenda[ itensVendaPK=" + itensVendaPK + " ]";
    }
    
}
